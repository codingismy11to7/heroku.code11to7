require.config({
  paths: {
    jquery: '/assets/js/lib/jquery-1.11.1.min'
  }
})

require ['util/logger', 'jquery'], (logger, jQuery) ->
  logger.info "bootup"
  logger.info jQuery('.g-signin')
