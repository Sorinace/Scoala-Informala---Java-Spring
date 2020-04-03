<#include "./parts/header.ftl">


  </header>

  <div class="container mt-6">
    <div class="row">
      <div class="col-md-6">
        <div class="maincontent">
          <#if errors?has_content>
            <div class="container main-content">
                <ul class="list-group">
                    <li class="list-group-item list-group-item-danger"><h3>Error:</h3></li>
                    <#list errors as error>
                        <li class="list-group-item">${error}</li>
                    </#list>
                </ul>
            </div>
          <#else>
            <h2>${message}</h2><br/>
          </#if>
         <#if feedback_update?? >
                    <form class="feedback-form" action="/update/${feedback_update.getId()}" method="post">
                        <div class="form-group">
                          <label for="feedback-form-name">Name</label>
                          <input type="text" name = "name" class="form-control" id="feedback-form-name" value = "${feedback_update.getName()}">
                        </div>
                        <div class="form-group">
                          <label for="feedback-form-email">E-Mail</label>
                          <input type="text" name = "email" class="form-control" id="feedback-form-email" value = "${feedback_update.getEmail()}">
                        </div>
                        <div class="form-group">
                          <label for="feedback-form-title">Title</label>
                          <input type="text" name = "title" class="form-control" id="feedback-form-title" value = "${feedback_update.getTitle()}">
                        </div>
                        <div class="form-group">
                          <label for="feedback-form-message">Message</label>
                          <textarea type="text" name = "message" class="form-control"
                            id="feedback-form-message" rows="6">${feedback_update.getMessage()}</textarea>
                        </div>
                        <button type="submit" class="btn btn-secondary float-right">Update</button>
                      </form>

         <#else>
          <form class="feedback-form" action="/feedback" method="post">
            <div class="form-group">
              <label for="feedback-form-name">Name</label>
              <input type="text" name = "name" class="form-control" id="feedback-form-name" placeholder="Enter your name" value = "${feedback_form.getName()}">
            </div>
            <div class="form-group">
              <label for="feedback-form-email">E-Mail</label>
              <input type="text" name = "email" class="form-control" id="feedback-form-email" placeholder="Enter your email address" value = "${feedback_form.getEmail()}">
            </div>
            <div class="form-group">
              <label for="feedback-form-title">Title</label>
              <input type="text" name = "title" class="form-control" id="feedback-form-title" placeholder="Title of your feedback" value = "${feedback_form.getTitle()}">
            </div>
            <div class="form-group">
              <label for="feedback-form-message">Message</label>
              <textarea type="text" name = "message" placeholder="Enter your message, then hit the submit button" class="form-control"
                id="feedback-form-message" rows="6">${feedback_form.getMessage()}</textarea>
            </div>
            <button type="submit" class="btn btn-secondary float-right">Submit</button>
          </form>
        </#if>

        </div>
      </div>
      <aside class="col-md-6">
        <div class="maincontent feedback">
          <h1>Recent Feedback</h1>
          <div class="feedback-items">

            <#list feedback as feed>
               <#if feed.getVisible()>
                  <div class="feedback-item item-list media-list ">
                        <div class="feedback-item media">
                            <div class="feedback-info media-body">
                                  <div class="feedback-head">
                                        <div class="feedback-title">${feed.getTitle()}</div>
                                          <small>by ${feed.getName()}</small>
                                  </div>
                                        <div class="feedback-message">${feed.getMessage()}</div>
                             </div>
                        </div>
                      <#if admin>
                          <#include "./parts/crud.ftl">
                      </#if>
                 </div>
               <#elseif admin >
                  <div class="feedback-item item-list media-list hide">
                        <div class="feedback-item media">
                                      <div class="feedback-info media-body">
                                        <div class="feedback-head">
                                          <div class="feedback-title">${feed.getTitle()}</div>
                                          <small>by ${feed.getName()}</small>
                                        </div>
                                        <div class="feedback-message">${feed.getMessage()}</div>
                                      </div>
                        </div>
                      <#include "./parts/crud.ftl">
                  </div>
               </#if>

             </#list>

          </div>
        </div>
      </aside>
    </div>
  </div>

<#include "./parts/footer.ftl">