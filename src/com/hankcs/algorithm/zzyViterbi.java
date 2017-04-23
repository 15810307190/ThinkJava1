package com.hankcs.algorithm;

/**
 * Created by MiMi on 2017/4/23.
 */
public class zzyViterbi {
    public static int[] compute(int[] observation,int[] states,double[] start_p,double[][] trans_p,double[][] emit_p){
        double[][] v=new double[states.length][observation.length];
        int[][] path=new int[states.length][observation.length];
        //计算第一个观测值对应状态序列的概率
        for(int x:states){
            v[x][0]=start_p[x]*emit_p[x][0];
        }
        //计算第二至最后一个观测值对应状态序列的概率
        /**
         * y是观测序列的个数
         * xy是转换矩阵的列坐标
         * xx是横坐标，转换矩阵的行坐标和列坐标是一样的
         */
        for(int y=1;y<observation.length;y++){
            for(int xy:states){
                double prob=0;
                int state=0;
                for(int xx:states){
                    double proby=v[xx][y-1]*trans_p[xx][xy]*emit_p[xx][observation[y]];
                    //在计算后续概率的时候，都是求最大值，并记录上一个转换过来的状态
                    if(proby>prob){
                        prob=proby;
                        state=xy;
                    }
                }
                v[xy][y]=prob;
                path[xy][y]=state;
            }
        }
        //找出最后一列中概率最大的状态下标
        int[] result=new int[observation.length];
        double prob=0;
        int state=0;
        for(int i:states) {
            if (v[i][observation.length - 1] > prob) {
                prob = v[i][observation.length - 1];
                state = i;
            }
        }
        //从后开始往前取状态，存入到数组中返回
        for(int i=observation.length-1;i>=0;i--){
            result[i]=state;
            state=path[state][i];
        }
        return result;
    }
}
