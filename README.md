JavaEE Book Library
=================
Thomas Durieux & Cyrille Toulet

7 mai 2014

## Introduction

Ce projet consiste en un site web basé sur la technologie JavaEE et ses EJB. Ce site permet de consulter en commander des livres.
![Home](https://raw.githubusercontent.com/tdurieux/JavaEEBookLibrary/screenshots/home.png)
## API

## Book API
HTTP Méthodes | URL |Body           | Description
--------------|-----|---------------|-------------
GET           | /api/book/_bookTitle_ | |Récupérer un livre au format JSON
DELETE        | /api/book/_bookTitle_ | |Supprime un livre
PUT           | /api/book/_bookTitle_ | un livre au format JSON               |Crée un livre
POST          | /api/book/_bookTitle_  | Les nouvelles données du livre au format JSON | Met à jour les information du livre.
GET          | /api/books  |  |Récupère une liste de livres

## Order API
HTTP Méthodes | URL |Body           | Description
--------------|-----|---------------|-------------
GET           | /api/cart | |Récupérer le panier stocké dans la session
PUT           | /api/cart/_bookTitle_/_quantiry_ | | Ajoute un livre au panier
POST          | /api/cart/_bookTitle_/_quantiry_ | | Change la quantité de livre ajouté au panier
DELETE        | /api/cart/_bookTitle_ | |Supprime un livre du panier
PUT           | /api/cart/checkout | | Payer le panier

## Exception

### DAOException

Cette ```RunTimeException``` est lancée par les persisters.

BookPersisterImpl méthode createBook:
```JAVA
throw new DAOException("Unable to create the book", ex);
```

Cette exception est interceptée dans les managers.

```BookManager``` méthode createBook
```JAVA
} catch (DAOException e) {
  FacesMessage message = new 	FacesMessage(FacesMessage.SEVERITY_ERROR,
          "Create Book Failed!",
          "Title '"
          + bookTitle
          + "' does not exist.");
  context.addMessage(null, message);
  return null;
}
```
### NoResultException

La classe UserManager intercepte également les exceptions NoResultException dans la méthode de connexion (vérifier que l’utilisateur existe) et dans la méthode de création de compte utilisateur pour vérifier que le compte n’existe pas encore dans la base de données.

```UserManager``` méthode: validateUser
```JAVA
} catch (NoResultException e) {
  FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
          "Login Failed!",
          "Username '"
          + username
          + "' does not exist.");
  context.addMessage(null, message);
  return null;
}
```

## Architecture

### Diagramme de classe

#### lille1.car2014.durieux_toulet.doa
![DOA](https://raw.githubusercontent.com/tdurieux/JavaEEBookLibrary/screenshots/DAO.png)
#### lille1.car2014.durieux_toulet.entity
![Entities](https://raw.githubusercontent.com/tdurieux/JavaEEBookLibrary/screenshots/entities.png)
#### lille1.car2014.durieux_toulet.manager
![Manager](https://raw.githubusercontent.com/tdurieux/JavaEEBookLibrary/screenshots/managers.png)

### Interface

### Classe abstraite

## Code simple

#### Exemple d’entité

Voici en exemple le code de l’entité qui représente un livre. On  y voir les différentes annotations qui permette de la créer
- @Entity: Indique que la classe est une classe entité
- @Table(name = "WBOOK"): Défini le nom de la table dans la base de donnée
- @NamedQueries: Défini dans query lié à cette entité
- @Id: Défini que le champ titre est l’id du livre
- @Column(name = "title", nullable = false): Défini le nom de la colonne ainsi que la politique sur la valeur de ce champ

``` JAVA
@Entity
@Table(name = "WBOOK")
@NamedQueries({
  @NamedQuery(name = "books.findByTitle", query = "SELECT b FROM BookImpl b WHERE b.title LIKE :title"),
  @NamedQuery(name = "books.getAllBooks", query = "SELECT b FROM BookImpl b")
  …
})
public class BookImpl implements Book, Serializable {

  @Id
  @Column(name = "title", nullable = false)
  private String title;
  @Column(name = "author", nullable = false)
  private String author;
	…
  @Column(name = "price")
  private double price;
	…
}
```

#### Exemple de persistence

Permet de sauvegarder un objet book dans la base de données. On peut également y voir la gestion des transactions.
```JAVA
try {
  em.getTransaction().begin();
  em.persist((BookImpl) book);
  em.getTransaction().commit();
} catch (Exception ex) {
  if (em.getTransaction().isActive()) {
    em.getTransaction().rollback();
  }
  throw new DAOException("Unable to create the book", ex);
}
```
#### Exemple JSP

Cet exemple montre comment une requête d’ajout au panier est géré coté JSP. La liaison de l’action de l’utilisateur au code est réalisée grâce à la balise ```h:commandButton``` qui prend dans l’attribut action une méthode d’un managed-bean.

```HTML
<h:form id="order-${book.title}">
  <span class="price">${book.price}€ x</span>
  <h:inputText requiredMessage="*"
               id="${book.title}-quantity"
               value="1"
               styleClass="quantity"
               required="true">
    <f:convertNumber type="number" integerOnly="true" minIntegerDigits="0"/>
  </h:inputText>
  <h:commandButton value="Order"
                   styleClass="order"
                   action="#{ordermanager.addBookToCart}">
    <f:param name="title" value="#{book.title}" />
  </h:commandButton>
</h:form>
```

#### Gestion des accès
Dans cette exemple nous pouvons voir la méthode qui est appelée avant la génération d’une page. Cette méthode vérifie que la page soit bien public si l’utilisation n’est pas connecté sinon on le redirige vers la page de connexion.

```AuthenticationPhaseListener``` qui implémente ```PhaseListener```

```JAVA
  @Override
  public void afterPhase(PhaseEvent event) {
    FacesContext context = event.getFacesContext();

    if (!userExists(context)) {
      // check if the page is a secure view
      if (requestingSecureView(context)) {
        context.responseComplete();
	      // send the user to the login view
        context.getApplication().
                getNavigationHandler().handleNavigation(context,
                        null,
                        USER_LOGIN_OUTCOME);
      }
    }
  }
```

#### Accéder aux variables de sessions
Dans cette exemple nous voyons comment accéder et comment sauvegarder des informations de session.

```JAVA
public OrderImpl getOrder() {
    FacesContext context = FacesContext.getCurrentInstance();
    Map<String, Object> sessionMap = context.getExternalContext().getSessionMap();
    OrderImpl order = null;
    if (sessionMap.containsKey(CART_SESSION_KEY)) {
      order = (OrderImpl) sessionMap.get(CART_SESSION_KEY);
    } else {
      order = new OrderImpl();
      sessionMap.put(CART_SESSION_KEY, order);
    }
    return order;
 }
```
