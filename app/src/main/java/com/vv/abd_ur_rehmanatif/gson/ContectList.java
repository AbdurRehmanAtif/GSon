package com.vv.abd_ur_rehmanatif.gson;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by abd-ur-rehmanatif on 01/05/2017.
 */

public class ContectList {

    private String Id;
    private String Firstname;
    private String Username;
    private String Password;
    private String Gender;
    private String Address;
    private String phone;


    public String getId() {
        return Id;
    }

    public String getFirstname() {
        return Firstname;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public String getGender() {
        return Gender;
    }

    public String getAddress() {
        return Address;
    }

    public String getPhone() {
        return phone;
    }



    public  ContectList(String Id , String Firstname, String Username, String Password, String Gender, String Address, String phone){


        this.Id = Id;
        this.Firstname = Firstname;
        this.Username = Username;
        this.Password = Password;
        this.Gender = Gender;
        this.Address = Address;
        this.phone = phone;

    }



}
