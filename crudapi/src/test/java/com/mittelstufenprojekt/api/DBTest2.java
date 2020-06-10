package com.mittelstufenprojekt.api;

import com.mittelstufenprojekt.api.domain.Room;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class DBTest2 {
@Autowired
    EntityManager entityManager;

    @Test
    public void testRoomQuery() {

        TypedQuery<Room> query = entityManager.createNamedQuery("Room_Find_All", Room.class);
        List<Room> result = query.getResultList();
        System.out.println(result);
    }
}
