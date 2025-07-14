
import java.util.*;

class FriendNode {

    int friendId;
    FriendNode next;

    public FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

class UserNode {

    int userId;
    String name;
    int age;
    FriendNode friendsHead;
    UserNode next;

    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendsHead = null;
        this.next = null;
    }

    // Add friend by ID
    public void addFriend(int friendId) {
        if (!isFriend(friendId)) {
            FriendNode newFriend = new FriendNode(friendId);
            newFriend.next = friendsHead;
            friendsHead = newFriend;
        }
    }

    // Remove friend by ID
    public void removeFriend(int friendId) {
        if (friendsHead == null) {
            return;
        }
        if (friendsHead.friendId == friendId) {
            friendsHead = friendsHead.next;
            return;
        }
        FriendNode temp = friendsHead;
        while (temp.next != null && temp.next.friendId != friendId) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Check if friend exists
    public boolean isFriend(int friendId) {
        FriendNode temp = friendsHead;
        while (temp != null) {
            if (temp.friendId == friendId) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Get all friend IDs as a set
    public Set<Integer> getFriendIds() {
        Set<Integer> ids = new HashSet<>();
        FriendNode temp = friendsHead;
        while (temp != null) {
            ids.add(temp.friendId);
            temp = temp.next;
        }
        return ids;
    }

    // Display all friends
    public void displayFriends() {
        System.out.print("Friends of " + name + " (ID: " + userId + "): ");
        FriendNode temp = friendsHead;
        if (temp == null) {
            System.out.println("No friends.");
            return;
        }
        while (temp != null) {
            System.out.print(temp.friendId + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Count number of friends
    public int countFriends() {
        int count = 0;
        FriendNode temp = friendsHead;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

class UserLinkedList {

    private UserNode head;

    // Add user
    public void addUser(int userId, String name, int age) {
        UserNode newUser = new UserNode(userId, name, age);
        newUser.next = head;
        head = newUser;
    }

    // Search user by ID
    public UserNode searchById(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Search user by Name
    public UserNode searchByName(String name) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Add friend connection between two users
    public void addFriendConnection(int userId1, int userId2) {
        UserNode user1 = searchById(userId1);
        UserNode user2 = searchById(userId2);
        if (user1 != null && user2 != null && userId1 != userId2) {
            user1.addFriend(userId2);
            user2.addFriend(userId1);
        }
    }

    // Remove friend connection between two users
    public void removeFriendConnection(int userId1, int userId2) {
        UserNode user1 = searchById(userId1);
        UserNode user2 = searchById(userId2);
        if (user1 != null && user2 != null) {
            user1.removeFriend(userId2);
            user2.removeFriend(userId1);
        }
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userId1, int userId2) {
        UserNode user1 = searchById(userId1);
        UserNode user2 = searchById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        Set<Integer> friends1 = user1.getFriendIds();
        Set<Integer> friends2 = user2.getFriendIds();
        friends1.retainAll(friends2);
        System.out.print("Mutual friends between " + user1.name + " and " + user2.name + ": ");
        if (friends1.isEmpty()) {
            System.out.println("None");
        } else {
            for (int id : friends1) {
                System.out.print(id + " ");
            }
            System.out.println();
        }
    }

    // Display all friends of a user
    public void displayFriendsOfUser(int userId) {
        UserNode user = searchById(userId);
        if (user != null) {
            user.displayFriends();
        } else {
            System.out.println("User not found.");
        }
    }

    // Count friends for each user
    public void countFriendsForAll() {
        UserNode temp = head;
        while (temp != null) {
            System.out.println(temp.name + " (ID: " + temp.userId + ") has " + temp.countFriends() + " friends.");
            temp = temp.next;
        }
    }
}

public class SocialMediaFriendConnections {

    public static void main(String[] args) {
        UserLinkedList users = new UserLinkedList();

        // Add users
        users.addUser(1, "Alice", 25);
        users.addUser(2, "Bob", 30);
        users.addUser(3, "Charlie", 22);
        users.addUser(4, "Diana", 28);

        // Add friend connections
        users.addFriendConnection(1, 2);
        users.addFriendConnection(1, 3);
        users.addFriendConnection(2, 3);
        users.addFriendConnection(3, 4);

        // Display friends
        users.displayFriendsOfUser(1);
        users.displayFriendsOfUser(2);
        users.displayFriendsOfUser(3);
        users.displayFriendsOfUser(4);

        // Find mutual friends
        users.findMutualFriends(1, 2);
        users.findMutualFriends(1, 4);

        // Remove friend connection
        users.removeFriendConnection(1, 3);
        users.displayFriendsOfUser(1);
        users.displayFriendsOfUser(3);

        // Search user
        UserNode found = users.searchByName("Bob");
        if (found != null) {
            System.out.println("Found user: " + found.name + ", ID: " + found.userId);
        }

        // Count friends for all users
        users.countFriendsForAll();
    }
}
