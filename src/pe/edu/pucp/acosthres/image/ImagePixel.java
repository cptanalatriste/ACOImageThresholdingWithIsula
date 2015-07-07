package pe.edu.pucp.acosthres.image;

import java.util.ArrayList;
import java.util.List;

public class ImagePixel {

  private int coordinateForX;
  private int coordinateForY;
  private int greyScaleValue;

  /**
   * Creates a new Pixel of a specified image.
   * 
   * @param coordinateForX
   *          X coordinate.
   * @param coordinateForY
   *          Y coordinate.
   * @param imageGraph
   *          Graph representation of the image.
   */
  public ImagePixel(int coordinateForX, int coordinateForY,
      double[][] imageGraph) {
    super();
    this.coordinateForX = coordinateForX;
    this.coordinateForY = coordinateForY;
    this.greyScaleValue = (int) imageGraph[coordinateForX][coordinateForY];
  }

  public int getxCoordinate() {
    return coordinateForX;
  }

  public void setxCoordinate(int coordinateForX) {
    this.coordinateForX = coordinateForX;
  }

  public int getyCoordinate() {
    return coordinateForY;
  }

  public void setyCoordinate(int coordinateForY) {
    this.coordinateForY = coordinateForY;
  }

  public int getGreyScaleValue() {
    return greyScaleValue;
  }

  public void setGreyScaleValue(int greyScaleValue) {
    this.greyScaleValue = greyScaleValue;
  }

  /**
   * Return the surrounding neighbours of this pixel.
   * 
   * @param imageGraph
   *          Graph representation of the image.
   * @return List os surrounfing pixels.
   */
  public List<ImagePixel> getNeighbourhood(double[][] imageGraph) {
    // TODO(cgavidia): There must be a more elegant way to do this

    ArrayList<ImagePixel> neighbours = new ArrayList<ImagePixel>();
    if (coordinateForY - 1 >= 0) {
      neighbours.add(new ImagePixel(coordinateForX, coordinateForY - 1,
          imageGraph));
    }

    if (coordinateForY + 1 < imageGraph[0].length) {
      neighbours.add(new ImagePixel(coordinateForX, coordinateForY + 1,
          imageGraph));
    }

    if (coordinateForX - 1 >= 0) {
      neighbours.add(new ImagePixel(coordinateForX - 1, coordinateForY,
          imageGraph));
    }

    if (coordinateForX + 1 < imageGraph.length) {
      neighbours.add(new ImagePixel(coordinateForX + 1, coordinateForY,
          imageGraph));
    }

    if (coordinateForX - 1 >= 0 && coordinateForY - 1 >= 0) {
      neighbours.add(new ImagePixel(coordinateForX - 1, coordinateForY - 1,
          imageGraph));
    }

    if (coordinateForX + 1 < imageGraph.length && coordinateForY - 1 >= 0) {
      neighbours.add(new ImagePixel(coordinateForX + 1, coordinateForY - 1,
          imageGraph));
    }

    if (coordinateForX - 1 >= 0 && coordinateForY + 1 < imageGraph[0].length) {
      neighbours.add(new ImagePixel(coordinateForX - 1, coordinateForY + 1,
          imageGraph));
    }

    if (coordinateForX + 1 < imageGraph.length
        && coordinateForY + 1 < imageGraph[0].length) {
      neighbours.add(new ImagePixel(coordinateForX + 1, coordinateForY + 1,
          imageGraph));
    }

    return neighbours;
  }

  @Override
  public String toString() {
    return "(" + this.getxCoordinate() + ", " + this.getyCoordinate() + ")  ";
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }

    final ImagePixel visitedPixel = (ImagePixel) obj;

    if (visitedPixel.getxCoordinate() == this.getxCoordinate()
        && visitedPixel.getyCoordinate() == this.getyCoordinate()
        && visitedPixel.getGreyScaleValue() == this.getGreyScaleValue()) {
      return true;
    }

    return false;
  }
}
