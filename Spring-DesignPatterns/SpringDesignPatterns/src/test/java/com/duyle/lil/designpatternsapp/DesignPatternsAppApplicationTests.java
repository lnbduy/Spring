package com.duyle.lil.designpatternsapp;
import com.duyle.lil.designpatternsapp.prototype.ProtoFalse;
import com.duyle.lil.designpatternsapp.prototype.ProtoTrue;
import com.duyle.lil.designpatternsapp.singleton.SingA;
import com.duyle.lil.designpatternsapp.singleton.SingB;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DesignPatternsAppApplicationTests {
    @Autowired
    SingB singB1;
    @Autowired
    SingB singB2;

    @Autowired
    ProtoTrue protoTrue1;
    @Autowired
    ProtoTrue protoTrue2;

    @Autowired
    ProtoFalse protoFalse1;
    @Autowired
    ProtoFalse protoFalse2;

    @Test
    public void testSingletons() {
        SingA singA1 = SingA.getInstance();
        SingA singA2 = SingA.getInstance();
        assertNotNull(singA1);
        assertSame(singA1, singA2);
        assertNotNull(singB1);
        assertSame(singB1, singB2);
    }

    @Test
    public void testPrototypes() {
        assertSame(protoFalse1, protoFalse2);
        assertNotSame(protoTrue1, protoTrue2);
    }
}

