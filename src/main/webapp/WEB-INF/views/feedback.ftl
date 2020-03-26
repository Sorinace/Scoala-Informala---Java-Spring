<#include "./parts/header.ftl">
<#list feedback as feed>
    ${feed["summary"]} <br/>
</#list>

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

            <div class="feedback-item item-list media-list">
              <div class="feedback-item media">
                <div class="feedback-info media-body">
                  <div class="feedback-head">
                    <div class="feedback-title">Impressive</div>
                    <small>by Jane</small>
                  </div>
                  <div class="feedback-message">Please do it again</div>
                </div>
              </div>
            </div>

            <div class="feedback-item item-list media-list">
              <div class="feedback-item media">
                <div class="feedback-info media-body">
                  <div class="feedback-head">
                    <div class="feedback-title">I'll be back
                    </div>
                    <small>by James</small>
                  </div>
                  <div class="feedback-message">I'm happy that I was there</div>
                </div>
              </div>
            </div>
            <div class="feedback-item item-list media-list">
              <div class="feedback-item media">
                <div class="feedback-info media-body">
                  <div class="feedback-head">
                    <div class="feedback-title">Great Speaker</div>
                    <small>by Melissa</small>
                  </div>
                  <div class="feedback-message">This was a great meetup!</div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </aside>
    </div>
  </div>

<#include "./parts/footer.ftl">