<#include "./parts/header.ftl">

  <article class="speakerslist jumbotron d-none d-sm-block">
    <div class="container">
      <div class="row">

      <#list speakers as speaker>
        <div class="col-md text-center">
          <h4 class="speakerslist-title">${speaker.getTitle()}</h4>
          <div class="speakerslist-name">with
            <a href="/speakers/${speaker.getId()}">${speaker.getName()}</a>
          </div>
          <p class="speakerslist-info mt-2"> <a href="/speakers/${speaker.getId()}">
              <img class="speakerslist-img rounded-circle" src="./images/speakers/${speaker.getShortname()}_tn.jpg"
                alt="Photo of ${speaker.getName()}">
            </a>
          </p>
        </div>
       </#list>

      </div>
    </div>
  </article>

  <div class="container mt-4">
    <div class="row">
      <div class="col-md-8">
        <article class="article maincontent">
          <h1>Who are we?</h1>
          <p>The Roux Academy gets thousands of submissions every year for artists interesting in participating in the
            CAC exhibits, and selects approximately 200 distinct pieces of contemporary art for display in their
            collective exhibit.
            In addition, 12 individuals are honored as Featured Artists - each being granted his or her own exhibit
            hall to display entire collections or themed pieces.</p>
          <p>Each Featured Artist has an opportunity to speak at one of our meetups and share his or her vision,
            perspective, and techniques with attendees on a more personal level than at our large conference. It is
            truly an honor to be a
            CAC Featured Artist and many past students artists who were featured at CAC have gone on to brilliant
            careers in art.</p>
        </article>
        <article class="article maincontent">
          <h2 class="article-title">Get Busy!</h2>
          <p>If you want to keep up with what&apos;s going on with the group, <a
              href="http://www.meetup.com/rouxmeet">join our meetup group</a>,
            <a href="http://www.twitter.com/rouxmeet">follow us on twitter</a>. If you&apos;re in FaceBook, you can
            also <a href="http://www.facebook.com/rouxmeet">join our FaceBook group</a>.</p>
        </article>
      </div>

      <aside class="col-md-4">
        <article class="sidebar">
          <h1 class="sidebar-title">Who should come?</h1>
          <ul class="sidebar-body">
            <li>Anybody interested in art and the creative industry</li>
            <li>Painters, sculptors, photographers and graphic artists</li>
            <li>Those interested in meeting and making a connection with others in the local art scene.</li>
          </ul>
        </article>
        <article class="sidebar">
          <h1 class="sidebar-title">Artwork on display</h1>
          <p class="sidebar-body">While you attend the conference, head over to our gallery where you can check out some
            of the work from our speakers.</p>
            <#include "./parts/allimg.ftl">
        </article>
      </aside>
    </div>
  </div>

<#include "./parts/footer.ftl">