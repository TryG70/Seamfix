package com.bvn.bvnvalidationservice.serviceImpl;

import com.bvn.bvnvalidationservice.entity.Bvn;
import com.bvn.bvnvalidationservice.exception.EmptyBVNException;
import com.bvn.bvnvalidationservice.exception.InvalidBVNDataTypeException;
import com.bvn.bvnvalidationservice.exception.InvalidBVNException;
import com.bvn.bvnvalidationservice.exception.InvalidBVNLengthException;
import com.bvn.bvnvalidationservice.repository.BVNRepository;
import com.bvn.bvnvalidationservice.request.BVNRequest;
import com.bvn.bvnvalidationservice.response.BVNErrorResponse;
import com.bvn.bvnvalidationservice.response.BVNResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class BVNServiceImplTest {

    @Mock
    private BVNRepository bvnRepository;

    @InjectMocks
    private BVNServiceImpl bvnService;


    @BeforeEach
    void setUp() {
    }

    @Test
    void testValidateBVN() {

        Long startTime = System.currentTimeMillis();

        BVNRequest request = BVNRequest.builder().bvn("12345678901").build();

        String bvn = request.getBvn();

        BVNResponse response = BVNResponse.builder()
                .message("BVN is valid")
                .code("00")
                .bvn(bvn)
                .imageDetail("Image is valid")
                .basicDetail("Basic detail is valid")
                .build();

        Bvn<?> bvnEntity = Bvn.builder()
                .bvnRequest(request)
                .bvnResponse(response)
                .build();

        var actual = bvnService.validateBVN(request);

        verify(bvnRepository, times(1)).save(bvnEntity);
        assertEquals(response.getMessage(), actual.getMessage());
        assertEquals(response.getCode(), actual.getCode());
        assertEquals(response.getBvn(), actual.getBvn());
        assertEquals(response.getImageDetail(), actual.getImageDetail());
        assertEquals(response.getBasicDetail(), actual.getBasicDetail());

        Long endTime = System.currentTimeMillis();
        assertTrue((endTime - startTime) < 5000);
    }


    @Test
    void testEmptyBVN() {
        Long startTime = System.currentTimeMillis();

        BVNRequest request = BVNRequest.builder().bvn("").build();
        String message = "One or more of your request parameters failed validation. Please retry";

        BVNErrorResponse response = BVNErrorResponse.builder()
                .message(message)
                .code("400")
                .bvn(request.getBvn())
                .build();

        Bvn<?> bvnEntity = Bvn.builder()
                .bvnRequest(request)
                .bvnResponse(response)
                .build();

        assertThrows(EmptyBVNException.class, () -> bvnService.validateBVN(request));
        verify(bvnRepository, times(1)).save(bvnEntity);

        Long endTime = System.currentTimeMillis();
        assertTrue((endTime - startTime) < 1000);
    }


    @Test
    void testInvalidBVN() {
        Long startTime = System.currentTimeMillis();

        BVNRequest request = BVNRequest.builder().bvn("12245778901").build();
        String message = "The searched BVN does not exist";


        BVNErrorResponse response = BVNErrorResponse.builder()
                .message(message)
                .code("01")
                .bvn(request.getBvn())
                .build();

        Bvn<?> bvnEntity = Bvn.builder()
                .bvnRequest(request)
                .bvnResponse(response)
                .build();

        assertThrows(InvalidBVNException.class, () -> bvnService.validateBVN(request));
        verify(bvnRepository, times(1)).save(bvnEntity);

        Long endTime = System.currentTimeMillis();
        assertTrue((endTime - startTime) < 1000);
    }


    @Test
    void testInvalidBVNLength() {
        Long startTime = System.currentTimeMillis();

        BVNRequest request = BVNRequest.builder().bvn("123456789").build();
        String message = "The searched BVN is invalid";

        BVNErrorResponse response = BVNErrorResponse.builder()
                .message(message)
                .code("02")
                .bvn(request.getBvn())
                .build();

        Bvn<?> bvnEntity = Bvn.builder()
                .bvnRequest(request)
                .bvnResponse(response)
                .build();

        assertThrows(InvalidBVNLengthException.class, () -> bvnService.validateBVN(request));
        verify(bvnRepository, times(1)).save(bvnEntity);

        Long endTime = System.currentTimeMillis();
        assertTrue((endTime - startTime) < 1000);
    }


    @Test
    void testInvalidBVNDataType() {
        Long startTime = System.currentTimeMillis();

        BVNRequest request = BVNRequest.builder().bvn("1234b67890a").build();
        String message = "The searched BVN is invalid";

        BVNErrorResponse response = BVNErrorResponse.builder()
                .message(message)
                .code("400")
                .bvn(request.getBvn())
                .build();

        Bvn<?> bvnEntity = Bvn.builder()
                .bvnRequest(request)
                .bvnResponse(response)
                .build();

        assertThrows(InvalidBVNDataTypeException.class, () -> bvnService.validateBVN(request));
        verify(bvnRepository, times(1)).save(bvnEntity);

        Long endTime = System.currentTimeMillis();
        assertTrue((endTime - startTime) < 1000);
    }

}