![jpa-one-to-many-diagram](https://www.bezkoder.com/wp-content/uploads/2022/01/jpa-one-to-many-diagram.png)



| Methods | Urls                        | Actions                                       |
| :------ | :-------------------------- | :-------------------------------------------- |
| POST    | /api/tutorials/:id/comments | create new Comment for a Tutorial             |
| GET     | /api/tutorials/:id/comments | retrieve all Comments of a Tutorial           |
| GET     | /api/comments/:id           | retrieve a Comment by `:id`                   |
| PUT     | /api/comments/:id           | update a Comment by `:id`                     |
| DELETE  | /api/comments/:id           | delete a Comment by `:id`                     |
| DELETE  | /api/tutorials/:id          | delete a Tutorial (and its Comments) by `:id` |
| DELETE  | /api/tutorials/:id/comments | delete all Comments of a Tutorial             |



```java
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_generator")
```



```java
@ManyToOne(fetch = FetchType.LAZY, optional = false)
@JoinColumn(name = "tutorial_id", nullable = false)
@OnDelete(action = OnDeleteAction.CASCADE)
@JsonIgnore
private Tutorial tutorial;
```
