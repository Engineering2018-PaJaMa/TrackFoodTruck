package com.example.pajama.trackfoodtruck.httpUserController;

import com.example.pajama.trackfoodtruck.Data.User;

public interface HttpUserInterface {

    void httpGetUser(User user);

    void httpPutUser(String info);

}