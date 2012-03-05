// Copyright (c) 2012, The SAVI Project.
package ca.savi.testbed.authentication.datastore;

import ca.savi.moon.datastore.DataStore;
import ca.savi.moon.datastore.DataStoreFactory;
import ca.savi.testbed.authentication.model.Credential;
import ca.savi.testbed.authentication.model.User;

/**
 * The data access object for Wilson.
 *
 * @author Soheil Hassas Yeganeh <soheil@cs.toronto.edu>
 * @version 0.1
 */
public class AuthenticationDataStore {
  public final static Class<?>[] PERSISTENT_CLASSES = {
    User.class,
    Credential.class
  };

  public final static String HIBERNATE_CONFIG_FILE =
      "/ca/savi/testbed/authentication/wilson.hb.cfg.xml";

  private final DataStore store;

  /**
   * Initializes the data store.
   */
  public AuthenticationDataStore() {
    DataStoreFactory factory = new DataStoreFactory();
    this.store = factory.createDataStore(HIBERNATE_CONFIG_FILE,
        PERSISTENT_CLASSES);
  }

  public User findUser(String username) {
    return store.findObject(User.class, username);
  }

  public Credential findCredential(String username) {
    return store.findObject(Credential.class, username);
  }

  public DataStore getDataStore() {
    return store;
  }
}
