package plus1s.app.model;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by ivorycandy on 6/20/17.
 * Service Provider
 * provides functions of accessing Firebase
 */

public class Database {
    private Account user;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    public void upLoadRequest() {
        Account user = UserDetails.getCurrentUser();
        DatabaseReference myRef = database.getReference(user.getUsername());
        myRef.setValue(user);
    }

    public Account downloadRequest(String username) {
        DatabaseReference myRef = database.getReference(username);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                user = dataSnapshot.getValue(Account.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        return user;
    }


}
