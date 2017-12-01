package com.zt.serviceListener.util;

import com.zt.serviceListener.App;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

public class RandomUtil {
    private static SecureRandom sRandom = null;
    private static Random random = new Random();
    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static int nextInt(int range) {
        if (range < 0) {
            LOG.warn("invalid range: " + range);
            return range;
        } else {
            return Optional.of(getSecureRandom()).map(r -> r.nextInt(range)).orElse(random.nextInt(range));
        }
    }

    private static SecureRandom getSecureRandom(){
        if (Objects.isNull(sRandom))
        {
            try {
                sRandom = SecureRandom.getInstance("SHA1PRNG");
                sRandom.nextInt();
            } catch (NoSuchAlgorithmException e) {
                LOG.error("SecureRandom get error.", e);
            }
        }
        return sRandom;
    }
}
