/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucene.cosinesimilarity;

import java.util.Map;
import org.apache.commons.math.linear.OpenMapRealVector;
import org.apache.commons.math.linear.RealVectorFormat;

/**
 *
 * @author Mubin
 */
public class DocVector {

    public Map<String, Integer> terms;
    public OpenMapRealVector vector;
    
    public DocVector(Map<String, Integer> terms) {
        this.terms = terms;
        this.vector = new OpenMapRealVector(terms.size());        
    }

    public void setEntry(String term, int freq) {
        if (terms.containsKey(term)) {
            int pos = terms.get(term);
            vector.setEntry(pos, (double) freq);
        }
    }

    public void normalize() {
        double sum = vector.getL1Norm();
        vector = (OpenMapRealVector) vector.mapDivide(sum);
    }

    @Override
    public String toString() {
        RealVectorFormat formatter = new RealVectorFormat();
        return formatter.format(vector);
    }
}