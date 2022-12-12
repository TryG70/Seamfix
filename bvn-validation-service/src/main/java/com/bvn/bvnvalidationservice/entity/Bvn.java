package com.bvn.bvnvalidationservice.entity;

import com.bvn.bvnvalidationservice.request.BVNRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "seamfix")
public class Bvn<T> {

    private ObjectId id = new ObjectId();

    private BVNRequest bvnRequest;

    private T bvnResponse;
}
