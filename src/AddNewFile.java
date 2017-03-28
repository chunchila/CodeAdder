import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.MessageType;
import com.intellij.openapi.ui.popup.Balloon;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.StatusBar;
import com.intellij.openapi.wm.WindowManager;
import com.intellij.ui.awt.RelativePoint;

/**
 * Created by Dirt on 3/26/2017.
 */
public class AddNewFile extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        //System.out.println(e.getProject().getProjectFile());


        Project currentProject = DataKeys.PROJECT.getData(e.getDataContext());
        VirtualFile currentFile = DataKeys.VIRTUAL_FILE.getData(e.getDataContext());
        Editor editor = DataKeys.EDITOR.getData(e.getDataContext());
        String path = currentFile.getCanonicalPath();


        if (currentFile.getExtension() != null) {


            StatusBar statusBar = WindowManager.getInstance()
                    .getStatusBar(DataKeys.PROJECT.getData(e.getDataContext()));

            JBPopupFactory.getInstance()
                    .createHtmlTextBalloonBuilder("Choose Package Not File", MessageType.ERROR, null)
                    .setFadeoutTime(3000)
                    .createBalloon()
                    .show(RelativePoint.getCenterOf(statusBar.getComponent()),
                            Balloon.Position.atRight);


        } else {
            StatusBar statusBar = WindowManager.getInstance()
                    .getStatusBar(DataKeys.PROJECT.getData(e.getDataContext()));

            JBPopupFactory.getInstance()
                    .createHtmlTextBalloonBuilder("Seccess", MessageType.INFO, null)
                    .setFadeoutTime(3000)
                    .createBalloon()
                    .show(RelativePoint.getCenterOf(statusBar.getComponent()),
                            Balloon.Position.atRight);

        }
        //System.out.println("extension " + currentFile.getExtension());


        // ** this is for creating class under the path

        /*String dirName = " ";
        int rand = new Random().nextInt(9999);
        String clasName = "walla" + rand + ".class";


        final PsiManager psiManager = PsiManager.getInstance(currentProject);


        PsiDirectory psiDirectory = psiManager.findDirectory(currentFile);

        JavaDirectoryService.getInstance().createClass(psiDirectory, clasName, JavaTemplateUtil.INTERNAL_CLASS_TEMPLATE_NAME, true);*/


    }
}
