package com.bvn.bvnvalidationservice.enums;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public enum BVNValue {

    VALID_BVN("12345678901") {
        @Override
        public String toString() {
            return "12345678901";
        }
    },
    ;

    BVNValue(String s) {
    }
}
