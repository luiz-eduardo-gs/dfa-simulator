package app;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

public class Main 
{
    public static void main(String[] args)
    {
        /*Abre um FileChooser para selecionar o arquivo de entrada de dados*/
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        File selectedFile = null;
        int returnValue = jfc.showOpenDialog(null);
        if(returnValue == JFileChooser.APPROVE_OPTION)
        {
            selectedFile = jfc.getSelectedFile();
//            System.out.println(selectedFile.getAbsolutePath());
            JOptionPane.showMessageDialog(null, selectedFile.getAbsolutePath());
        }
        
        /*Le o arquivo de entrada*/
        StringBuilder content = new StringBuilder();
        
        if(selectedFile != null)
        {
            try(BufferedReader br = new BufferedReader(new FileReader(selectedFile.getAbsolutePath())))
            {
                String line;
                
                while((line = br.readLine()) != null)
                {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
                
                JOptionPane.showMessageDialog(null, content.toString());
            }
            catch(FileNotFoundException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            catch(IOException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        
        /*Organiza o arquivo em variavel*/
        String[] fields = content.toString().split(System.lineSeparator());
        for(String linha : fields)
        {
            System.out.println(linha);
        }
    }
}
