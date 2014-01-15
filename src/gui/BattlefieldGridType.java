/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jme3.texture.Texture;
import java.nio.ByteBuffer;

/**
 *
 * @author mnn
 */
public class BattlefieldGridType {
    public static final int GRID_GRASS  = 0;
    public static final int GRID_ROCK   = 1;
    public static final int GRID_TREE   = 2;
    public static final int GRID_WATER  = 3;
    
    private ByteBuffer _texture_buffer;
    private int _type;
    
    /**
     * makes a new ByteBuffer from the given texture file and keeps it in memory
     * @param texture_name
     * @param type 
     */
    public BattlefieldGridType (Texture texture, int type) {
        _texture_buffer = texture.getImage().getData(0);
        _type = type;
    }
    
    public int get_type () {
        return _type;
    }
}
