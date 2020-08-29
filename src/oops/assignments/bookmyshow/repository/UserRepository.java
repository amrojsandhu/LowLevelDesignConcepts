package oops.assignments.bookmyshow.repository;

import oops.assignments.bookmyshow.objects.User;

public class UserRepository extends Repository<User, String> {

    public void save(User user) {
        super.save(user, user.getId());
    }

}
