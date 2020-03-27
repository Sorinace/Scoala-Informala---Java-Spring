<#include "./parts/header.ftl">


  </header>

  <div class="container mt-4">
    <div class="row">
      <div class="col-md-4">
        <div class="maincontent">
          <h1>Send us feedback</h1>
          <form class="feedback-form">
            <div class="form-group">
              <label for="feedback-form-name">Name</label>
              <input type="text" class="form-control" id="feedback-form-name" placeholder="Enter your name">
            </div>
            <div class="form-group">
              <label for="feedback-form-email">E-Mail</label>
              <input type="text" class="form-control" id="feedback-form-email" placeholder="Enter your email address">
            </div>
            <div class="form-group">
              <label for="feedback-form-title">Title</label>
              <input type="text" class="form-control" id="feedback-form-title" placeholder="Title of your feedback">
            </div>
            <div class="form-group">
              <label for="feedback-form-message">Message</label>
              <textarea type="text" placeholder="Enter your message, then hit the submit button" class="form-control"
                id="feedback-form-message" rows="6"></textarea>
            </div>
            <button type="submit" class="btn btn-secondary float-right">Submit</button>
          </form>
        </div>
      </div>
      <aside class="col-md-8">
        <div class="maincontent feedback">
          <h1>Recent Feedback</h1>

          <div class="feedback-items">
            <#list feedback as feed>
                <div class="feedback-item item-list media-list">
                  <div class="feedback-item media">
                    <div class="feedback-info media-body">
                      <div class="feedback-head">
                        <div class="feedback-title">${feed["title"]}</div>
                        <small>by ${feed["name"]}</small>
                      </div>
                      <div class="feedback-message">${feed["message"]}</div>
                    </div>
                  </div>
                </div>

            </#list>

          </div>
        </div>
      </aside>
    </div>
  </div>

<#include "./parts/footer.ftl">