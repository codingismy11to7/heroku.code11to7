define ['util/logger', 'jquery'], (logger, $) ->
  class Login
    bootstrapGoogle: (csrfToken) ->
      @csrfToken = csrfToken

      po = document.createElement("script")
      po.async = true
      po.src = 'https://plus.google.com/js/client:plusone.js?onload=start'
      s = document.getElementsByTagName("script")[0]
      s.parentNode.insertBefore(po, s)

    callback: (authInfo) =>
      logger.info authInfo

  new Login
