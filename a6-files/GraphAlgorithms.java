/*
	Name: Jakob Valen
	Student ID: V00943160
*/

import java.awt.Color;
import java.util.*;

public class GraphAlgorithms{

	/* FloodFillDFS(v, writer, fillColour)
	   Traverse the component the vertex v using DFS and set the colour
	   of the pixels corresponding to all vertices encountered during the
	   traversal to fillColour.

	   To change the colour of a pixel at position (x,y) in the image to a
	   colour c, use
			writer.setPixel(x,y,c);
	*/
	public static void FloodFillDFS(PixelVertex v, PixelWriter writer, Color fillColour){
		//writer.setPixel(v.getX(), v.getY(), fillColour);

		Stack<PixelVertex> pixel_stack = new Stack<>();

		pixel_stack.push(v);

		Hashtable<PixelVertex,Integer> visted_table = new Hashtable<>();


		while(pixel_stack.size()>0){

			PixelVertex current = pixel_stack.pop();

			if(visted_table.containsKey(current)){
				continue;

			}else{

				visted_table.put(current,1);
				writer.setPixel(current.getX(),current.getY(),fillColour);

				LinkedList<PixelVertex> current_neighbours = current.getNeighbours();

				for(int i = 0;i<current_neighbours.size();i++){
					pixel_stack.push(current_neighbours.get(i));

				}
			}
		}
	}

	/* FloodFillBFS(v, writer, fillColour)
	   Traverse the component the vertex v using BFS and set the colour
	   of the pixels corresponding to all vertices encountered during the
	   traversal to fillColour.

	   To change the colour of a pixel at position (x,y) in the image to a
	   colour c, use
			writer.setPixel(x,y,c);
	*/
	public static void FloodFillBFS(PixelVertex v, PixelWriter writer, Color fillColour){

		Queue<PixelVertex> pixel_q = new LinkedList<>();
		Hashtable<PixelVertex,Integer> visted_table = new Hashtable<>();


		pixel_q.add(v);
		visted_table.put(v,1);
		writer.setPixel(v.getX(), v.getY(), fillColour);

		while(pixel_q.size()>0){

			PixelVertex current = pixel_q.remove();

			LinkedList<PixelVertex> current_neighbours = current.getNeighbours();

			for(int i=0;i<current_neighbours.size();i++){

				if(visted_table.containsKey(current_neighbours.get(i))){
					continue;
				}else{

					visted_table.put(current_neighbours.get(i),1);
					writer.setPixel(current_neighbours.get(i).getX(), current_neighbours.get(i).getY(), fillColour);
					pixel_q.add(current_neighbours.get(i));

				}
			}
		}
	}

}
