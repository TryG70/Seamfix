package com.algorithm.seamfixalgorithm;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SeamfixAlgorithmApplication {

    public static void main(String[] args) {

        int sampleTest1 = numberOfFraudAlertNotification(9, 5, new int[] {2,3,4,2,3,6,8,4,5});
        int sampleTest2 = numberOfFraudAlertNotification(8, 3, new int[] {12,9,1,7,15,5,2,8});


        System.out.println("Number of notifications: " + sampleTest1);
        System.out.println("Number of notifications: " + sampleTest2);

    }


    private static int numberOfFraudAlertNotification(int nDays, int dDays, int[] totalDailyExpenditure) {
        int numberOfFraudAlertNotification = 0;

        if(nDays != totalDailyExpenditure.length) {
            throw new ArrayIndexOutOfBoundsException("totalDailyExpenditure data size does not match n number of days");
        }

        if(nDays <= dDays) {
            return 0;
        } else {
            for (int i = 0, j = dDays; j < nDays; i++, j++) {

                int[] subArray = Arrays.copyOfRange(totalDailyExpenditure, i, j);
                Arrays.sort(subArray);

                int median = subArray[subArray.length / 2];

                if (subArray.length % 2 == 0) {
                    median = (median + subArray[subArray.length / 2 - 1]) / 2;
                }

                if (totalDailyExpenditure[j] >= 2 * median) {
                    numberOfFraudAlertNotification++;
                }
            }
        }
        return numberOfFraudAlertNotification;
    }



}
