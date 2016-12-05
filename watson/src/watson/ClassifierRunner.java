//package watson;
//
//import watson.WatsonApiConfig;
//import watson.WatsonJsonParser;
//
//public class ClassifierRunner {
//
//    // Trained last night with "OUTPUT_DATA-21:44:32-12-01-2016.csv" under classifier_id "b7339ax137-nlc-334"
//    public static void main(String[] args) {
//
//        final String phraseToClassify = "YOUR PHRASE";
//        WatsonJsonParser jsonParser = new WatsonJsonParser();
//        ToneCat classifier = new ToneCat(new WatsonApiConfig(), jsonParser);
//
//        /* review the methods before running this */
//        classifier.createJob("pathToCsv");
//        System.out.println(classifier.classify(phraseToClassify));
//    }
//
//}