/*
 * Zyonic Software - 2020 - Tobias Rempe
 * This File, its contents and by extention the corresponding project may be used freely in compliance with the Apache 2.0 License.
 *
 * tobiasrempe@zyonicsoftware.com
 */

package com.zyonicsoftware.maddox.core.startup;

import com.zyonicsoftware.maddox.config.BaseValueConfig;
import com.zyonicsoftware.maddox.core.main.Maddox;

public class Initializer {

    public static void main(String[] args) {
        Maddox maddox = new Maddox();
        PreLoader preLoader = new PreLoader(maddox);
        BaseValueConfig config = new BaseValueConfig();

        preLoader.loadConfigFile(config);

        maddox.startup(config.getAmountShards(), config, preLoader);


        //ShutdownHook
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                System.out.println("Shutdown Starting");
                System.out.println("Application Termiating ...");
            }
        });
    }

}