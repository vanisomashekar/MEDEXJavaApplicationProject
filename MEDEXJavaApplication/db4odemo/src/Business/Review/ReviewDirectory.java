/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Review;

import java.util.ArrayList;

/**
 *
 * @author vaniv
 */
public class ReviewDirectory {
    private ArrayList<Review> reviewList;

    public ReviewDirectory() {
        reviewList = new ArrayList();
    }

    public ArrayList<Review> getReviewList() {
        return reviewList;
    }
    
     public Review createReview(String Desc,int rating){
         Review r = new Review();
         r.setDescription(Desc);
         r.setRating(rating);
         reviewList.add(r);
         return r;
     }
}
