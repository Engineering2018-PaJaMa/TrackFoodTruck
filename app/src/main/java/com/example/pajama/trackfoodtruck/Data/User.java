package com.example.pajama.trackfoodtruck.Data;

import java.util.List;
import java.util.Map;

public class User {

	private Map<String, Object> _id;

	private String login;

	private String password;

	private String email;

	private Integer errorMsg = 0;

	private List<String> favouriteFoodTrucks;

	public List<String> getFavouriteFoodTrucks()
	{
		return favouriteFoodTrucks;
	}

	public void setFavouriteFoodTrucks(List<String> favouriteFoodTrucks)
	{
		this.favouriteFoodTrucks = favouriteFoodTrucks;
	}

	public Integer getErrorMsg()
	{
		return errorMsg;
	}

	public void setErrorMsg(Integer errorMsg)
	{
		this.errorMsg = errorMsg;
	}

	public Map<String, Object> get_id()
	{
		return _id;
	}

	public void set_id(Map<String, Object> _id)
	{
		this._id = _id;
	}

	public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
