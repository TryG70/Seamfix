package com.bvn.bvnvalidationservice.serviceImpl;

import com.bvn.bvnvalidationservice.entity.Bvn;
import com.bvn.bvnvalidationservice.enums.BVNValue;
import com.bvn.bvnvalidationservice.exception.EmptyBVNException;
import com.bvn.bvnvalidationservice.exception.InvalidBVNDataTypeException;
import com.bvn.bvnvalidationservice.exception.InvalidBVNException;
import com.bvn.bvnvalidationservice.exception.InvalidBVNLengthException;
import com.bvn.bvnvalidationservice.repository.BVNRepository;
import com.bvn.bvnvalidationservice.request.BVNRequest;
import com.bvn.bvnvalidationservice.response.BVNErrorResponse;
import com.bvn.bvnvalidationservice.response.BVNResponse;
import com.bvn.bvnvalidationservice.service.BVNService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class BVNServiceImpl implements BVNService {


    private final BVNRepository bvnRepository;


    @Override
    public BVNResponse validateBVN(BVNRequest request) {

        String bvn = request.getBvn();

        if(bvn.equals(BVNValue.VALID_BVN.toString())) {

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

            bvnRepository.save(bvnEntity);

            return response;
        }

        if(bvn.isEmpty()) {

            String message = "One or more of your request parameters failed validation. Please retry";

            BVNErrorResponse response = BVNErrorResponse.builder()
                    .message(message)
                    .code("400")
                    .bvn(bvn)
                    .build();

            saveBVN(request, response);

            throw new EmptyBVNException(message, bvn);
        }

        if(!bvn.equals(BVNValue.VALID_BVN.toString()) && bvn.length() >= 11 && bvn.matches("[0-9]+")) {

            String message = "The searched BVN does not exist";

            BVNErrorResponse response = BVNErrorResponse.builder()
                    .message(message)
                    .code("01")
                    .bvn(bvn)
                    .build();

            saveBVN(request, response);

            throw new InvalidBVNException(message, bvn);
        }

        if(bvn.length() < 11) {

            String message = "The searched BVN is invalid";

            BVNErrorResponse response = BVNErrorResponse.builder()
                    .message(message)
                    .code("02")
                    .bvn(bvn)
                    .build();

            saveBVN(request, response);

            throw new InvalidBVNLengthException(message, bvn);
        }

        if(!bvn.matches("[0-9]+")) {

            String message = "The searched BVN is invalid";

            BVNErrorResponse response = BVNErrorResponse.builder()
                    .message(message)
                    .code("400")
                    .bvn(bvn)
                    .build();

            saveBVN(request, response);

            throw new InvalidBVNDataTypeException(message, bvn);
        }

        return null;
    }


    public void saveBVN(BVNRequest request, Object response) {
        Bvn<?> bvnEntity = Bvn.builder()
                .bvnRequest(request)
                .bvnResponse(response)
                .build();
        bvnRepository.save(bvnEntity);
    }

}
