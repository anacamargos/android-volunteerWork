package com.example.ana.volunteerwork.database;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by gabri on 03/12/2017.
 */

public class Database {

    /**
     * Inserir valores ao banco de dados
     * @param mChildId Id do dado inserido no banco de dados
     * @param ChildValue O que ser inserido no banco de dados
     */
    public static void Inserir(String mChildId,String ChildValue) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference mRef = database.getReference(mChildId);
        mRef.setValue(ChildValue);
    }

    /**
     * Remover valores do banco de dados
     * @param mChildId Id do dado a ser removido do banco de dados
     */

    public static void Remover(String mChildId) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference mRef = database.getReference(mChildId);
        mRef.removeValue();
    }

    public static void Ler(final String mChildId) {
        String retorno;
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference mRef = database.getReference(mChildId);
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String childValue = String.valueOf(dataSnapshot.getValue());
                // Cria um objeto ou alguma coisa pra ser lida daqui
                // Inserir(mChildId,childValue); <- Teste inserindo um valor com que foi lido do BD
                // TextView.setText(ChildValue)
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }




}
