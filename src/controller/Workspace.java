package controller;

import java.util.Observable;
import java.util.Observer;
import frontEnd.Canvas;

public class Workspace implements Observer{

    private Canvas myView;
    
    public Workspace(Canvas view){
        myView = view;
    }
    
    
    @Override
    public void update (Observable arg0, Object arg1) {
        // TODO Auto-generated method stub
        
    }

}
