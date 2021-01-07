import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.InvalidParameterException;
import java.text.MessageFormat;
import java.util.ArrayList;

public class GroupList {
	ArrayList<Group> groups;
	int idCounterGroup = 0;
	
	public GroupList() {
		groups = new ArrayList<>();
	}
	 public void add(Group g) throws Exception {
		 if (g == null) {
			 System.out.println("Mistake input");
		 }else
		 {
			 groups.add(g);
			 idCounterGroup++;
			 g.setId(idCounterGroup);
			 exportToFileGroup();
		 }
	 }
	 public void update(int id, Group g) throws Exception {
		 for (int i = 0; i < groups.size(); ++i) {
			 if (groups.get(i).getId() == id) {
				 if (g.getNameGroup() != null) {
					 groups.get(i).setNameGroup(g.getNameGroup());
					 exportToFileGroup();
					 break;
				 }
			 }
		 }
	 }
	 public void remove(int id) throws Exception {
		 for (Group group: groups) {
			 if (group.getId() == id) {
				 groups.remove(group);
				 exportToFileGroup();
				 break;
			 }
		 }
	 }
	 public ArrayList<Group> getGroups(){
		 return groups;
	 }
	 public Group getGroup(int id) {
		for (Group group: groups) {
			if (id == group.getId()) {
				return group;
			}
		}
		return null;
	 }
	 
	 private static final String FILENAMEGROUP = "db_group.txt";
	 
	 private void exportToFileGroup() throws Exception{
		 BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAMEGROUP));
		 for (Group g: groups) {
			 exportToFileGroup(bw, g);
		 }
		 bw.flush();
		 bw.close();
	 }
	 private void exportToFileGroup(BufferedWriter bw, Group g) throws Exception{
		 bw.write(g.getId()+"_"+g.getNameGroup()+"\n");
		 
	 }
	 public void importFromFileGroup() throws Exception {
		 BufferedReader br = new BufferedReader(new FileReader(FILENAMEGROUP));
		 while (true) {
			 String line = br.readLine();
			 if (line == null || line.contentEquals("")) {
				 break;
			 }
			 String[] data = line.split("_");
			 int idGroup = Integer.parseInt(data[0]);
			 String nameGroup = data[1];
			 Group g = new Group(nameGroup);
			 g.setId(idGroup);
			 groups.add(g);
		 }
	 }
}
