package chuggaChugga.data;

import java.util.ArrayList;

public class Path {

    private ArrayList<PathPart> path;

    public ArrayList<PathPart> addPart(PathPart part) {
        if (path == null) {
            path = new ArrayList<>();
        }
        path.add(part);
        return path;
    }

    public ArrayList<PathPart> getPath() {
        return path;
    }

}
