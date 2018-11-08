/*
 * Author: Pedro Contipelli
 */

import java.awt.geom.*;
import java.util.*;
public class banshee_DoralAcademy {
public static void main(String[] args) {
Scanner scan = new Scanner(System.in);

Point[] pts = new Point[3];

for (int i = 0; i < 3; i++)
	pts[i] = new Point(scan.nextInt() , scan.nextInt());

Line2D barrier = new Line2D.Float(pts[0].x , pts[0].y , pts[1].x , pts[1].y);
Line2D banshee = new Line2D.Float(0 , 0 , pts[2].x , pts[2].y);
	
if (barrier.intersectsLine(banshee) && !(barrier.ptSegDist(pts[2].x , pts[2].y) == 0))
	System.out.println("You're on your own, Master Chief.");
else
	System.out.println("Good Work Marine!");

scan.close();
	}
}

class Point {
	
int x , y;

public Point(int x , int y) {
	this.x = x;
	this.y = y;
}

}
