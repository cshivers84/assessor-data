package org.assessordata.batch.assessordata_batch;

public class App {
    public static void main( String[] args ) {
        if (FileHandler.updateFile()) {
        	FileHandler.updateData();
        }
    }
}
