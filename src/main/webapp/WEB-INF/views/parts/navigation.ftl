<nav class="navbar navbar navbar-expand-md navbar-dark bg-dark">
      <div class="container">
        <button type="button" class="navbar-toggler collapsed" data-toggle="collapse" data-target="#navbar-collapse"
          aria-expanded="false"> <span class="sr-only">Toggle navigation</span>
          &#x2630;</button> <a href="/" class="navbar-brand">Roux Meetups</a>
        <div class="collapse navbar-collapse" id="navbar-collapse">
          <ul class="nav navbar-nav ml-auto">
            <li class="nav-item"> <a href="/" class="nav-link">Home</a>
            </li>
            <li class="nav-item dropdown">
              <a href="/speakers" class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Speakers
              </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="/speakers">All Speakers</a>
                <div class="dropdown-divider"></div>
                <#list speakers as speaker>
                  <a class="dropdown-item" href="/speakers/${speaker.getId()}"> ${speaker.getName()}  </a>
                </#list>
              </div>
            </li>
            <li class="nav-item"> <a href="/feedback" class="nav-link">Feedback</a>
            </li>
            <li class="nav-item"> <a href="/login" class="nav-link">Login</a>
            </li>
          </ul>
        </div>
      </div>
   </nav>