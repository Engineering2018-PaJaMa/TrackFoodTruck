package com.example.pajama.trackfoodtruck.httpReviewsController;

import com.example.pajama.trackfoodtruck.Data.Review;

public interface HttpReviewsIntreface {
    void getReviews(Review review);

    void putReview(String backInfo);
}
