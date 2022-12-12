package com.bvn.bvnvalidationservice.service;

import com.bvn.bvnvalidationservice.request.BVNRequest;
import com.bvn.bvnvalidationservice.response.BVNResponse;

public interface BVNService {

    BVNResponse validateBVN(BVNRequest request);
}
