package neu.edu.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.creator.CreatorCreation;
import neu.edu.dao.CreatorDao;
import neu.edu.dao.IdeaDao;
import neu.edu.dao.UserDao;
import neu.edu.entity.Creator;
import neu.edu.entity.Idea;
import neu.edu.entity.User;

@Service
public class CreatorService {
@Autowired
CreatorDao creatorDao;
@Autowired
UserDao userDao;
@Autowired
IdeaDao ideaDao;
@Transactional
	public boolean delete(Integer categoryId) {
		// TODO Auto-generated method stub
		Creator creator=creatorDao.findOne(categoryId);
		if(creator.getIdeas().isEmpty()) {
			List<User> users=(List<User>) creator.getUsers();
			users.get(0).setCreator(null);
			userDao.save(users.get(0));
			creatorDao.delete(creator);
		}
		return false;
	}
	
	public List<CreatorCreation> getCreators() {
		// TODO Auto-generated method stub
		List<Creator>creators=creatorDao.findAll();
		List<CreatorCreation>creatorCreations=new ArrayList<CreatorCreation>();
		for(Creator creator:creators) {
			CreatorCreation creatorCreation=new CreatorCreation();
			ArrayList<User>users=new ArrayList<>(creator.getUsers());
			creatorCreation.setCreatorId(creator.getCreatorId());
			creatorCreation.setName(users.get(0).getPerson().getFirstName());
			creatorCreation.setLastDate(creator.getLastIdeaDate());
			creatorCreation.setReason(creator.getReason());
			creatorCreation.setStatus(creator.getStatus());
			creatorCreations.add(creatorCreation);
		}
		return creatorCreations;
	}
	@Transactional
	public boolean disable(Integer creatorId,String Reason) {
		// TODO Auto-generated method stub
		Creator creator=creatorDao.findOne(creatorId);
		if(creator!=null) {
			creator.setStatus("disable");
			creator.setReason(Reason);
			for(Idea idea:creator.getIdeas()) {
				disableIdea(idea,Reason);
			}
			creatorDao.save(creator);
			return true;
		}
		else return false;
	}
	@Transactional
	public void  disableIdea(Idea idea,String Reason) {
		idea.setStatus("disable");
		idea.setReason(Reason);
		ideaDao.save(idea);
	}
}
