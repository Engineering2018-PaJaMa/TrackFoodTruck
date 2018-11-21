package com.example.pajama.trackfoodtruck.httpReviewsController;

import com.example.pajama.trackfoodtruck.Data.Review;

public interface HttpReviewsIntrface
{
    void getReviews(Review review);

    void putReview(String backInfo);
}
