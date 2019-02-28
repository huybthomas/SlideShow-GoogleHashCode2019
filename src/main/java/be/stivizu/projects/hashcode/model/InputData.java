package be.stivizu.projects.hashcode.model;

import be.stivizu.projects.hashcode.util.SortPhotosUtil;

import java.util.ArrayList;
import java.util.List;

public class InputData {

    /*
        TODO[REQUIRED]: Add fields (primitive types or custom POJO's) to this class for all input data you want made
            available in the algorithm(s).
     */

    protected List<Photo> photos;
    public SortPhotosUtil sortPhotosUtil;

    public InputData(final List<String> fileData) {
        sortPhotosUtil = new SortPhotosUtil();
        photos = new ArrayList<>();
        int numberOfPhotos = Integer.parseInt(fileData.get(0));
        for (int i = 1; i <= numberOfPhotos; i++) {
            String[] dataLine = fileData.get(i).split(" ");
            String orientation = dataLine[0];
            Photo photo = new Photo(i - 1, orientation);
            for (int tagIndex = 2; tagIndex < dataLine.length; tagIndex++) {
                photo.addTag(dataLine[tagIndex]);
            }
            photos.add(photo);
        }
        sortPhotosUtil.sortPhotos(photos);
    }

    public SortPhotosUtil getSortPhotosUtil() {
        return sortPhotosUtil;
    }
}
