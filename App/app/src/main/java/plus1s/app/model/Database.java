package plus1s.app.model;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Ivorycandy on 6/20/17.
 * Service Provider
 * provides functions of accessing Firebase
 */

public class Database {
    private Account user;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    public void upLoadRequest() {
        Account user_1 = UserDetails.getCurrentUser();
        Account user_2 = UserDetails.getRegisterUser();
        if (user_1 != null) {
            DatabaseReference myRef = database.getReference(user_1.getUsername());
            myRef.setValue(user_1);
        } else if (user_2 != null) {
            DatabaseReference myRef = database.getReference(user_2.getUsername());
            myRef.setValue(user_2);
        }
    }

    public Account downloadRequest(String username) {
        DatabaseReference myRef = database.getReference(username);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //user = dataSnapshot.getValue(User.class);
                if (dataSnapshot.exists()) {
                    user = dataSnapshot.getValue(User.class);
                } else {
                    user = null;
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return user;
    }


}
