package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.material.RenderState.BlendMode;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.queue.RenderQueue.Bucket;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.texture.Image;
import com.jme3.texture.Texture;
import com.jme3.texture.Texture.Type;
import com.jme3.texture.Texture.WrapAxis;
import com.jme3.texture.Texture.WrapMode;
import com.jme3.texture.Texture2D;
import com.jme3.ui.Picture;
import gui.GameGUI;
import java.nio.ByteBuffer;

/**
 * test
 * @author Michael Nilsson
 */
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        /*Picture pic = new Picture("HUD Picture");
        pic.setImage(assetManager, "Textures/ColonialMarines_4.png", true);
        pic.setWidth(32);
        pic.setHeight(32);
        pic.setPosition(settings.getWidth()/4, settings.getHeight()/4);
        rootNode.attachChild(pic);
        */
        GameGUI gui_display = new GameGUI (assetManager,
                                           inputManager,
                                           audioRenderer,
                                           guiViewPort);
        
        
        ByteBuffer final_buf = ByteBuffer.allocateDirect(4 * 32 * 32 * 4);
        
        Texture tex_grass = assetManager.loadTexture("Textures/grass.png");
        Texture tex_tree = assetManager.loadTexture("Textures/tree.png");
        Texture tex_rock = assetManager.loadTexture("Textures/rock.png");
        Texture tex_water = assetManager.loadTexture("Textures/water.png");
        
        System.out.println("Image format: " + tex_grass.getImage().getFormat().toString());
        
        ByteBuffer grass_buffer = tex_grass.getImage().getData(0);
        ByteBuffer tree_buffer = tex_tree.getImage().getData(0);
        ByteBuffer rock_buffer = tex_rock.getImage().getData(0);
        ByteBuffer water_buffer = tex_water.getImage().getData(0);
        
        grass_buffer.rewind();
        tree_buffer.rewind();
        rock_buffer.rewind();
        water_buffer.rewind();
        
        for (int i = 0; i < 32; ++i) {
            for (int j = 0; j < 32*4; ++j) {
                final_buf.put(grass_buffer.get());
            }
            for (int j = 0; j < 32*4; ++j) {
                final_buf.put(tree_buffer.get());
            }
        }
        for (int i = 0; i < 32; ++i) {
            for (int j = 0; j < 32*4; ++j) {
                final_buf.put(rock_buffer.get());
            }
            for (int j = 0; j < 32*4; ++j) {
                final_buf.put(water_buffer.get());
            }
        }
        
        
        //buf.flip();
        
        
        //final_buf.put(grass_buffer);
        
        
        //final_buf.put(tree_buffer);
        
        
        //final_buf.put(rock_buffer);
        
        
        //final_buf.put(water_buffer);
        
        final_buf.flip();
        
        Image final_img = new Image(Image.Format.ABGR8, 64, 64, final_buf);
        
        Texture final_tex = new Texture2D(64, 64, Image.Format.ABGR8);
        final_tex.setImage(final_img);
        
        
        
        Box cube2Mesh = new Box( 1f,1f,0.01f);
        Geometry cube2Geo = new Geometry("window frame", cube2Mesh);
        Material cube2Mat = new Material(assetManager, 
            "Common/MatDefs/Misc/Unshaded.j3md");
        cube2Mat.setTexture("ColorMap", final_tex);
        //cube2Mat.setTexture("ColorMap", 
        //    assetManager.loadTexture("Textures/ColonialMarines_4.png"));
        //cube2Mat.getAdditionalRenderState().setBlendMode(BlendMode.Alpha);
        //cube2Geo.setQueueBucket(Bucket.Transparent);
        cube2Geo.setMaterial(cube2Mat);
        rootNode.attachChild(cube2Geo);
        
        flyCam.setEnabled(false);
        flyCam.setDragToRotate(true);

        //rootNode.attachChild(geom);
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
