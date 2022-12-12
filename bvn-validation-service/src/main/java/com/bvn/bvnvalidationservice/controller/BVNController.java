package com.bvn.bvnvalidationservice.controller;

import com.bvn.bvnvalidationservice.request.BVNRequest;
import com.bvn.bvnvalidationservice.response.BVNResponse;
import com.bvn.bvnvalidationservice.service.BVNService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bv-service")
public class BVNController {

    private final BVNService bvnService;


    @PostMapping("/svalidate/wrapper")
    public BVNResponse validateBvn(@RequestBody BVNRequest request) {
        return bvnService.validateBVN(request);
    }
}
