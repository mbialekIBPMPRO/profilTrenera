package com.example.profiltrenera;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddingColToDBServices {
    private final AddingColToDBCommponent addingColToDBCommponent;

    @Autowired
    public AddingColToDBServices(AddingColToDBCommponent addingColToDBCommponent) {
        this.addingColToDBCommponent = addingColToDBCommponent;
    }

    public void executeQueryadd(){
        addingColToDBCommponent.addColumnToPlayersTable();
    }

    public void executeQuerydrop(){
        addingColToDBCommponent.dropColumnToPlayersTable();
    }

}
