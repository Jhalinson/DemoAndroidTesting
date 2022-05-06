package com.qik.qa.exceptions;

public class ProjectsExceptions extends Exception{
    public ProjectsExceptions(String message){
        super("Issue::: " + message);
    }
}
