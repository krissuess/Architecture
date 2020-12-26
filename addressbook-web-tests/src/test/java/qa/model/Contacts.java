package qa.model;
import com.google.common.collect.ForwardingSet;
import java.util.HashSet;
import java.util.Set;

public class Contacts extends ForwardingSet<ContactData> {

    private Set<ContactData> delegate;

    public Contacts(Contacts contacts){
        this.delegate = new HashSet<>(contacts.delegate);
    }

    public Contacts() {
        this.delegate = new HashSet<>();
    }

    @Override
    protected Set<ContactData> delegate() {
        return delegate;
    }

    public Contacts withAdded(ContactData contactData){
        Contacts contacts = new Contacts(this);
        contacts.add(contactData);
        return contacts;
    }

    public Contacts without(ContactData contactData){
        Contacts contacts = new Contacts(this);
        contacts.remove(contactData);
        return contacts;
    }



}
