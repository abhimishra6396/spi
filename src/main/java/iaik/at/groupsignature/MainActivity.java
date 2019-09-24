package iaik.at.groupsignature;

import java.util.Random;

public class MainActivity {
    private String message;
    private GroupPublicKey gpk;
    private GroupSecretKey[] gsks;
    private GroupSecretKey actualGsk;
    private SdhSignature sign;

    static {
        System.loadLibrary("gss");
    }

    /*private String name;
    @Override
    public String toString() {
        return name;
    }*/

    public MainActivity(){
        message = "Fuck";

        boolean isWrongMessage = false;

        gpk =  new GroupPublicKey();

        gsks = generateGsks();
        actualGsk = gsks[0];

        sign = sign(message, gpk, gsks[2]);
        message = "Fuck";
    }

    public SdhSignature getSign() {
        System.out.println("Verification Result: "+verify(message, gpk, sign));
        //System.out.println("Sign: "+sign);
        return sign;
    }

    public String getMessage() {
        return message;
    }

    public GroupPublicKey getGpk() {
        //System.out.println("Message: "+ message);
        //System.out.println("GPK: "+ gpk);
        return gpk;
    }

    public GroupSecretKey[] getGsks() {
        return gsks;
    }

    public GroupSecretKey getActualGsk() {
        //System.out.println("GSK: "+ actualGsk);
        return actualGsk;
    }

    /**
     * Generates an array of random Integers
     *
     * @param size the length of the output int array
     * @return random int array of given size
     */
    private int[] generateRandomIntArray(int size) {
        int[] result = new int[size];
        Random r =  new Random();
        for (int i = 0; i < size; i++) {
            result[i] = r.nextInt();
        }
        return result;
    }

    /**
     * Generates an array of secret key out of hardcoded values (only demo app)
     *
     * @return array of secret keys
     */
    private GroupSecretKey[] generateGsks(){
        int[][] x_all = {{0x804ac869 ,0x1204797c ,0x6ced7e12 ,0xbc8a5e8b ,0x8693c3d3 ,0xa63c68ae ,0x93668dcb ,0x04a086ba},
                {0xda636964 ,0xd691f340 ,0x3ddbdf59 ,0x63f1fb9d ,0x362124f4 ,0xc7732a3b ,0x07bddee3 ,0x1b1cd79e},
                {0x16c13222 ,0xc54730fe ,0x2521226c ,0xc6119dc6 ,0x561fd355, 0x3af41d75 ,0x15bde049, 0x0d1ce030},
                {0xbf53373d ,0x88587b75 ,0x8b6c7dbb ,0x4c8202ff ,0xc3c0aa58 ,0xaa86e4e3 ,0x77d2817f ,0x16def47a}};

        int[][] A_x_all = {{0x7e9db9e6 ,0x4948d7ba ,0x3a90d5ab ,0xe8ebc5e5 ,0x381d3b8a ,0x32b61247 ,0x20c10a0e ,0x03f2b493},
                {0x086bac37 ,0x3c9f4ea5 ,0xda15cb34 ,0xdb438d16 ,0x10905e92 ,0x888491eb ,0xf79f65bb ,0x1ba2c9fa},
                {0x6b226fe9 ,0x656ea8cf ,0x000e3782 ,0xbb159453 ,0x57065892 ,0x31f6f630 ,0x748f7cc4 ,0x06e1a1dc},
                {0x7f13e88c ,0xecbefb70 ,0x768fd003 ,0xdfaebdf1 ,0x3b9a2321 ,0x3ae35f93 ,0xe9ab4b4e ,0x02997b19}};

        int[][] A_y_all = {{0xeced1a4e ,0x4d6319a3 ,0x9c3d2b93 ,0x71a7219b ,0x673fe027 ,0x96f48b93 ,0x3c13396f ,0x13f60481},
                {0x623a6b43 ,0x1e4461c3 ,0xb7646448 ,0xf84ceab0 ,0x534e077d ,0x3b424864 ,0x87289d6d ,0x237119da},
                {0xf64b8752, 0x9e278173 ,0x069eef26 ,0xbc9039de ,0xee48a698 ,0xab897d6a ,0x85ffb4c3 ,0x072e4b4c},
                {0x1c411103 ,0xd969dd05 ,0x8e956746 ,0x7f9726f9 ,0xa79ecf96 ,0x3ca8f4d7 ,0x972e3b81 ,0x1ac18d08}};
        final int number_of_gsks = 4;
        GroupSecretKey[] gsks = new GroupSecretKey[number_of_gsks];
        for (int i = 0; i < number_of_gsks; i++) {
            gsks[i] = new GroupSecretKey(x_all[i], A_x_all[i], A_y_all[i]);
        }
        return gsks;
    }

    /**
     * The native method for signing message from the user.
     *
     * @param message The message from the user
     * @param groupPublicKey The public key of the group scheme
     * @param groupSecretKey The secret key of a signer
     * @return The signature of the group scheme
     */
    public native SdhSignature sign(String message, GroupPublicKey groupPublicKey, GroupSecretKey groupSecretKey);

    /**
     * The native method to verify if the signature of the given message is valid.
     *
     * @param message The message from the user
     * @param groupPublicKey The used public key of the group scheme
     * @param sig The signature of the message
     * @return 0 if signature is valid, -1 if signature is invalid
     */
    public static native int verify(String message, GroupPublicKey groupPublicKey, SdhSignature sig);

    /**
     * The native method trace a signature to the signer.
     *
     * @param groupMasterSecretKey The secret key only the master knows
     * @param sig The signature of the message
     * @return The elliptic curve point corresponds to the signer
     */
    public static native EcPoint_Fp open(GroupMasterSecretKey groupMasterSecretKey, SdhSignature sig);
}
