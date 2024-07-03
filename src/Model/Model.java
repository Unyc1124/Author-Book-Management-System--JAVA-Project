package Model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Scanner;

public class Model
{

    protected manageAuthor manageAuthorData = new manageAuthor();
    protected manageBook manageBookData = new manageBook();



    public Model()
    {
        manageAuthorData.setLinesBeingDisplayed(25);
        manageAuthorData.setFirstLineToDisplay(0);
        manageBookData.setLinesBeingDisplayed(25);
        manageBookData.setFirstLineToDisplay(0);
    }
    public manageAuthor getManageAuthorData()
    {
        return manageAuthorData;
    }
    public manageBook getManageBookData()
    {
        return manageBookData;
    }

}

