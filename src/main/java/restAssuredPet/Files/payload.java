package restAssuredPet.Files;

public class payload {

    public static String AddNewPet(String name) {
        return "{\n" +
                "  \"id\": 0,\n" +
                "  \"category\": {\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Dog\"\n" +
                "  },\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"name\": \"golden\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
    }


    public static String UpdatePet(String name) {
        return "\n" +
                "{\n" +
                "    \"id\": 9222968140497314118,\n" +
                "    \"category\": {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Dog\"\n" +
                "    },\n" +
                "    \"name\": \"" + name + "\",\n" +
                "    \"photoUrls\": [\n" +
                "        \"string\"\n" +
                "    ],\n" +
                "    \"tags\": [\n" +
                "        {\n" +
                "            \"id\": 1,\n" +
                "            \"name\": \"golden\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"status\": \"available\"\n" +
                "}";


    }

    public static String PlaceOrder(String petId) {
        return "{\n" +
                "    \"id\": 5,\n" +
                "    \"petId\": \"" + petId + "\",\n" +
                "    \"quantity\": 2,\n" +
                "    \"shipDate\": \"15\",\n" +
                "    \"status\": \"available\",\n" +
                "    \"complete\": true\n" +
                "}";


    }


}